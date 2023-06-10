package BankSystemGUI;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5 {
	public String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] digest = md5.digest(str.getBytes("UTF-8"));
		String newstr = Base64.getEncoder().encodeToString(digest);
		return newstr;
	}

	public boolean checkPassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return encoderByMd5(newpasswd).equals(oldpasswd);
	}
}
