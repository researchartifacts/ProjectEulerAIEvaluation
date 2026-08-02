package com.comparisonai.gpt54minimodel.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class DownloadQuestions {

	private static final String BASE_URL = "https://projecteuler.net/minimal=";
	private static final Path OUTPUT_DIR = Path.of("problems");
	private static final int FIRST = 1;
	private static final int LAST = 1007;

	public static void main(String[] args) throws Exception {
		Files.createDirectories(OUTPUT_DIR);

		HttpClient client = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(30))
				.followRedirects(HttpClient.Redirect.NORMAL)
				.build();

		int success = 0;
		int failed = 0;

		for (int i = FIRST; i <= LAST; i++) {
			Path outFile = OUTPUT_DIR.resolve(i + ".txt");
			try {
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create(BASE_URL + i))
						.timeout(Duration.ofSeconds(30))
						.header("User-Agent", "DownloadQuestions/1.0")
						.GET()
						.build();

				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

				if (response.statusCode() == 200) {
					Files.writeString(outFile, response.body());
					success++;
					System.out.printf("Saved %s (%d/%d)%n", outFile.getFileName(), i, LAST);
				} else {
					failed++;
					System.err.printf("Failed %d: HTTP %d%n", i, response.statusCode());
				}

				// Be polite to the server
				Thread.sleep(200);
			} catch (Exception e) {
				failed++;
				System.err.printf("Failed %d: %s%n", i, e.getMessage());
			}
		}

		System.out.printf("Done. Saved: %d, Failed: %d, Output: %s%n", success, failed, OUTPUT_DIR);
	}
}
