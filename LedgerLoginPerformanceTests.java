
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class LedgerLoginPerformanceTests extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://dev-kc.singlewindow.io")
      .inferHtmlResources()
    ;
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_0.put("Accept-Encoding", "gzip, deflate, br");
    headers_0.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_0.put("Cache-Control", "max-age=0");
    headers_0.put("Origin", "null");
    headers_0.put("Sec-Fetch-Dest", "document");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("Upgrade-Insecure-Requests", "1");
    headers_0.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_0.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_4 = new HashMap<>();
    headers_4.put("Accept", "*/*");
    headers_4.put("Accept-Encoding", "gzip, deflate, br");
    headers_4.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_4.put("If-Modified-Since", "Tue, 17 Jan 2023 09:19:30 GMT");
    headers_4.put("If-None-Match", "W/\"2d0-185bf06c4d0\"");
    headers_4.put("Sec-Fetch-Dest", "manifest");
    headers_4.put("Sec-Fetch-Mode", "cors");
    headers_4.put("Sec-Fetch-Site", "same-origin");
    headers_4.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_4.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_4.put("sec-ch-ua-mobile", "?0");
    headers_4.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_5 = new HashMap<>();
    headers_5.put("Accept", "*/*");
    headers_5.put("Accept-Encoding", "gzip, deflate, br");
    headers_5.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_5.put("If-None-Match", "2-vyGp6PvFo4RvsFtPoIWeCReyIC8");
    headers_5.put("Sec-Fetch-Dest", "empty");
    headers_5.put("Sec-Fetch-Mode", "cors");
    headers_5.put("Sec-Fetch-Site", "same-origin");
    headers_5.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_5.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_5.put("sec-ch-ua-mobile", "?0");
    headers_5.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_6 = new HashMap<>();
    headers_6.put("Accept", "application/json, text/plain, */*");
    headers_6.put("Accept-Encoding", "gzip, deflate, br");
    headers_6.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_6.put("Sec-Fetch-Dest", "empty");
    headers_6.put("Sec-Fetch-Mode", "cors");
    headers_6.put("Sec-Fetch-Site", "same-origin");
    headers_6.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_6.put("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJTR19ta2lla1lkQnhvalRBRjN0NzA2SGxMRnRaTzJWNE1aMEkycWRUVWFNIn0.eyJleHAiOjE2NzQ4NDUxNDcsImlhdCI6MTY3NDgwMTk0OSwiYXV0aF90aW1lIjoxNjc0ODAxOTQ3LCJqdGkiOiI0MGMzNTM2Ni05MGJiLTQxNzYtYWE0Ni00NDI1NWZkY2JiMDAiLCJpc3MiOiJodHRwczovL2Rldi1rYy5zaW5nbGV3aW5kb3cuaW8vYXV0aC9yZWFsbXMvYWdzdyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJlZWQzYmIzYi1hYWYwLTQ1NGQtYjA1OC00OTczMDg1MTI0MWIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcm9kdWN0LWNhdGFsb2ciLCJzZXNzaW9uX3N0YXRlIjoiMmJjZTlkYmMtN2YwMS00YmJlLWFlNzUtYzM0OTkwMTI4YjA4IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwczovL2Rldi10YXJpZmUuc2luZ2xld2luZG93LmlvIiwiaHR0cHM6Ly90ZXN0LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHBzOi8vZGV2LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHA6Ly9sb2NhbGhvc3Q6MzAwMSJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgcHJvZHVjdC1jYXRhbG9nLXNjcCBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IktlbmFuIEfDvGxlciIsInByZWZlcnJlZF91c2VybmFtZSI6ImtlbmFuLmd1bGVyQGRjcy5jb20iLCJnaXZlbl9uYW1lIjoiS2VuYW4iLCJsb2NhbGUiOiJlbiIsImZhbWlseV9uYW1lIjoiR8O8bGVyIiwiZW1haWwiOiJrZW5hbi5ndWxlckBkY3MuY29tIiwiZ3JvdXAiOlsiL2xlZGdlciIsIi90YXJpZmYiXX0.vC0usDI_HsFNkykpP5tqkO8G9TOmUiHC1HvQZyHOkf2PIGEGco45zQJTgm165nsKTTJuUFQNGzRgTTykJrNgkoWHcrbHkTeK-Gwyrp5GdfAzqRbxIoLNcCcZ8k6MsspYzeEm5_J1Jn9QwPJaD9F6f_NKJcHJH4EEaFt4kymFd7Z9zxGqnj8LXacdnlTWEu_oTWAMcpoWPagPAgvnXee1lZ0kuJ91D7kmqODD9ytmpY88FIF4Rmy0KzvIvK2fcK1Spqo7L6s6oUQIdwUkAY6a8r_vt9rzwcvJYzPwJT9fPWd6RbT5Bpqmb8OVf4VUOQDxZvjl0o_LcGrVdrR2jip4Lw");
    headers_6.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_11 = new HashMap<>();
    headers_11.put("Accept", "*/*");
    headers_11.put("Accept-Encoding", "gzip, deflate, br");
    headers_11.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_11.put("Access-Control-Request-Headers", "authorization");
    headers_11.put("Access-Control-Request-Method", "GET");
    headers_11.put("Origin", "https://dev-productcatalog.singlewindow.io");
    headers_11.put("Sec-Fetch-Dest", "empty");
    headers_11.put("Sec-Fetch-Mode", "cors");
    headers_11.put("Sec-Fetch-Site", "same-site");
    headers_11.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_12 = new HashMap<>();
    headers_12.put("Accept", "application/json, text/plain, */*");
    headers_12.put("Accept-Encoding", "gzip, deflate, br");
    headers_12.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_12.put("Origin", "https://dev-productcatalog.singlewindow.io");
    headers_12.put("Sec-Fetch-Dest", "empty");
    headers_12.put("Sec-Fetch-Mode", "cors");
    headers_12.put("Sec-Fetch-Site", "same-site");
    headers_12.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_12.put("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJTR19ta2lla1lkQnhvalRBRjN0NzA2SGxMRnRaTzJWNE1aMEkycWRUVWFNIn0.eyJleHAiOjE2NzQ4NDUxNDcsImlhdCI6MTY3NDgwMTk0OSwiYXV0aF90aW1lIjoxNjc0ODAxOTQ3LCJqdGkiOiI0MGMzNTM2Ni05MGJiLTQxNzYtYWE0Ni00NDI1NWZkY2JiMDAiLCJpc3MiOiJodHRwczovL2Rldi1rYy5zaW5nbGV3aW5kb3cuaW8vYXV0aC9yZWFsbXMvYWdzdyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJlZWQzYmIzYi1hYWYwLTQ1NGQtYjA1OC00OTczMDg1MTI0MWIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcm9kdWN0LWNhdGFsb2ciLCJzZXNzaW9uX3N0YXRlIjoiMmJjZTlkYmMtN2YwMS00YmJlLWFlNzUtYzM0OTkwMTI4YjA4IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwczovL2Rldi10YXJpZmUuc2luZ2xld2luZG93LmlvIiwiaHR0cHM6Ly90ZXN0LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHBzOi8vZGV2LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHA6Ly9sb2NhbGhvc3Q6MzAwMSJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgcHJvZHVjdC1jYXRhbG9nLXNjcCBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IktlbmFuIEfDvGxlciIsInByZWZlcnJlZF91c2VybmFtZSI6ImtlbmFuLmd1bGVyQGRjcy5jb20iLCJnaXZlbl9uYW1lIjoiS2VuYW4iLCJsb2NhbGUiOiJlbiIsImZhbWlseV9uYW1lIjoiR8O8bGVyIiwiZW1haWwiOiJrZW5hbi5ndWxlckBkY3MuY29tIiwiZ3JvdXAiOlsiL2xlZGdlciIsIi90YXJpZmYiXX0.vC0usDI_HsFNkykpP5tqkO8G9TOmUiHC1HvQZyHOkf2PIGEGco45zQJTgm165nsKTTJuUFQNGzRgTTykJrNgkoWHcrbHkTeK-Gwyrp5GdfAzqRbxIoLNcCcZ8k6MsspYzeEm5_J1Jn9QwPJaD9F6f_NKJcHJH4EEaFt4kymFd7Z9zxGqnj8LXacdnlTWEu_oTWAMcpoWPagPAgvnXee1lZ0kuJ91D7kmqODD9ytmpY88FIF4Rmy0KzvIvK2fcK1Spqo7L6s6oUQIdwUkAY6a8r_vt9rzwcvJYzPwJT9fPWd6RbT5Bpqmb8OVf4VUOQDxZvjl0o_LcGrVdrR2jip4Lw");
    headers_12.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_12.put("sec-ch-ua-mobile", "?0");
    headers_12.put("sec-ch-ua-platform", "macOS");
    
    String uri2 = "https://fonts.gstatic.com/s/inter/v12";
    
    String uri3 = "https://fonts.googleapis.com/css2";
    
    String uri4 = "https://dev-productcatalog.singlewindow.io";
    
    String uri5 = "https://dev-tarife-service.singlewindow.io/api/v2-0/tariff-query/public/countries";

    ScenarioBuilder scn = scenario("LedgerLoginPerformanceTests")
      .exec(
        http("request_0")
          .post("/auth/realms/agsw/login-actions/authenticate?session_code=_KzHs7_Us1rd8VILPERJb-ZV302phFnju5W8poKc2WI&execution=c4351c58-ada8-4b6b-bd1c-f280081f1bcc&client_id=product-catalog&tab_id=k9Ms39TNKiI")
          .headers(headers_0)
          .formParam("username", "kenan.guler@dcs.com")
          .formParam("password", "qwer.123")
          .formParam("credentialId", "")
          .resources(
            http("request_1")
              .get(uri3 + "?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap"),
            http("request_2")
              .get(uri2 + "/UcC73FwrK3iLTeHuS_fvQtMwCp50KnMa1ZL7W0Q5nw.woff2"),
            http("request_3")
              .get(uri2 + "/UcC73FwrK3iLTeHuS_fvQtMwCp50KnMa25L7W0Q5n-wU.woff2"),
            http("request_4")
              .get(uri4 + "/manifest.json")
              .headers(headers_4),
            http("request_5")
              .get(uri4 + "/api/auth/session")
              .headers(headers_5),
            http("request_6")
              .get(uri4 + "/api/v1-0/users/self")
              .headers(headers_6),
            http("request_7")
              .get(uri4 + "/api/v1-0/notification-receivers/initial-notifications/30")
              .headers(headers_6),
            http("request_8")
              .get(uri4 + "/api/v1-0/work-orders/status-counts")
              .headers(headers_6),
            http("request_9")
              .get(uri4 + "/api/v1-0/work-orders/created-by-cbu/status-counts")
              .headers(headers_6),
            http("request_10")
              .get(uri4 + "/api/v1-0/legislation-change/notifications/all?isJustUnreads=false&startDate=2022-12-27T06:45:49.812Z")
              .headers(headers_6),
            http("request_11")
              .options(uri5)
              .headers(headers_11),
            http("request_12")
              .get(uri5)
              .headers(headers_12)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(100))).protocols(httpProtocol);
  }
}
