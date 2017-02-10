package com.github.teamscrum.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepUtil {

	public static void main(String[] args) throws IOException {
		buscarCep("62940000");
	}

	public static Map<String, String> buscarCep(String cep) {
		Map<String, String> mapa = null;
		String json = null;

		try {
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder jsonSb = new StringBuilder();

			br.lines().forEach(l -> jsonSb.append(l.trim()));

			json = jsonSb.toString();

			mapa = new HashMap<>();

			Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);

			while (matcher.find()) {
				String[] group = matcher.group().split(":");
				mapa.put(group[0].replaceAll("\"", "").trim(),
						group[1].replaceAll("\"", "").trim().replace("-", "").trim());
			}
			System.out.println(mapa);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return mapa;
	}
}
