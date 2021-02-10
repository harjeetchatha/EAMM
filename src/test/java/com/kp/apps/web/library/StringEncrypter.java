package com.kp.apps.web.library;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author HariKrishna Pesala
 */
public class StringEncrypter {

  private static StringEncrypter encrypter = null;

  /**
   * Default Constructor
   */
  public StringEncrypter() {

  }

  public static StringEncrypter createEncrypter() {
    if (encrypter == null) {
      try {
        encrypter = new StringEncrypter(StringEncrypter.DES_ENCRYPTION_SCHEME);
      } catch (EncryptionException e) {
        throw new RuntimeException(e);
      }
    }
    return encrypter;
  }

  public static StringEncrypter createNewEncrypter() {
    try {
      return new StringEncrypter(StringEncrypter.DES_ENCRYPTION_SCHEME);
    } catch (EncryptionException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * DESEDE Encryption Scheme
   */
  public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
  /**
   * DES Encryption Scheme
   */
  public static final String DES_ENCRYPTION_SCHEME = "DES";
  private static final String UNICODE_FORMAT = "UTF8";

  /**
   * Default Encryption Scheme
   */
  public static final String DEFAULT_ENCRYPTION_KEY =
      "This is a fairly long phrase used to encrypt";

  private KeySpec keySpec;
  private SecretKeyFactory keyFactory;
  private Cipher cipher;

  /**
   * @param anEncryptionScheme
   * @throws EncryptionException
   */
  public StringEncrypter(final String anEncryptionScheme) throws EncryptionException {
    this(anEncryptionScheme, DEFAULT_ENCRYPTION_KEY);
  }

  /**
   * @param anEncryptionScheme
   * @param anEncryptionKey
   * @throws EncryptionException
   */
  public StringEncrypter(final String anEncryptionScheme, final String anEncryptionKey)
      throws EncryptionException {

    if (anEncryptionKey == null) {
      throw new IllegalArgumentException("encryption key was null");
    }
    if (anEncryptionKey.trim().length() < 24) {
      throw new IllegalArgumentException("encryption key was less than 24 characters");
    }

    try {
      final byte[] keyAsBytes = anEncryptionKey.getBytes(UNICODE_FORMAT);

      if (anEncryptionScheme.equals(DESEDE_ENCRYPTION_SCHEME)) {
        keySpec = new DESedeKeySpec(keyAsBytes);
      } else if (anEncryptionScheme.equals(DES_ENCRYPTION_SCHEME)) {
        keySpec = new DESKeySpec(keyAsBytes);
      } else {
        throw new IllegalArgumentException("Encryption scheme not supported: " + anEncryptionScheme);
      }

      keyFactory = SecretKeyFactory.getInstance(anEncryptionScheme);
      cipher = Cipher.getInstance(anEncryptionScheme);

    } catch (final InvalidKeyException e) {
      throw new EncryptionException(e);
    } catch (final UnsupportedEncodingException e) {
      throw new EncryptionException(e);
    } catch (final NoSuchAlgorithmException e) {
      throw new EncryptionException(e);
    } catch (final NoSuchPaddingException e) {
      throw new EncryptionException(e);
    }

  }

  /**
   * @param anUnencryptedString
   * @return String
   * @throws EncryptionException
   */
  public String encrypt(final String anUnencryptedString) throws EncryptionException {
    if (anUnencryptedString == null || anUnencryptedString.trim().length() == 0) {
      throw new IllegalArgumentException("unencrypted string was null or empty");
    }

    try {
      final SecretKey key = keyFactory.generateSecret(keySpec);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      final byte[] cleartext = anUnencryptedString.getBytes(UNICODE_FORMAT);
      final byte[] ciphertext = cipher.doFinal(cleartext);

      final Base64 base64encoder = new Base64();
      return new String(base64encoder.encode(ciphertext));
    } catch (final Exception e) {
      throw new EncryptionException(e);
    }
  }

  /**
   * @param anEncryptedString
   * @return String
   * @throws EncryptionException
   */
  public String decrypt(final String anEncryptedString) throws EncryptionException {
    if (anEncryptedString == null || anEncryptedString.trim().length() <= 0) {
      throw new IllegalArgumentException("encrypted string was null or empty");
    }

    try {
      final SecretKey key = keyFactory.generateSecret(keySpec);
      cipher.init(Cipher.DECRYPT_MODE, key);
      final Base64 base64decoder = new Base64();
      final byte[] cleartext = base64decoder.decode(anEncryptedString.getBytes());
      final byte[] ciphertext = cipher.doFinal(cleartext);

      return bytes2String(ciphertext);
    } catch (final Exception e) {
      throw new EncryptionException(e);
    }
  }

  private static String bytes2String(final byte[] aBytes) {
    final StringBuffer stringBuffer = new StringBuffer();
    for (final byte aByte : aBytes) {
      stringBuffer.append((char) aByte);
    }
    return stringBuffer.toString();
  }

  /**
   * Custom Exception for catched while Encryption/Decryption process
   * 
   */
  @SuppressWarnings("serial")
  public static class EncryptionException extends Exception {
    /**
     * @param aThrowable - Throwable
     */
    public EncryptionException(final Throwable aThrowable) {
      super(aThrowable);
    }

    public EncryptionException(final String aMessage) {
      super(aMessage);
    }
  }
}
