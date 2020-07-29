package br.com.casamagalhaes.estagiocm.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import br.com.casamagalhaes.estagiocm.model.Usuario;

@Service
public class Criptografia {

	public String criptografarMD5(Usuario usuario) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		String senha = usuario.getSenha();
		md.update(senha.getBytes());
		byte[] hash = md.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10)
		         hexString.append( "0" + Integer.toHexString((0xFF & hash[i])));
		    else
		    	 hexString.append(Integer.toHexString(0xFF & hash[i]));
		}
		
		return hexString.toString();
	}
}
