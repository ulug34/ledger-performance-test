
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class CreateWorkOrderPerformanceTest extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://dev-productcatalog.singlewindow.io")
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
    headers_4.put("If-None-Match", "2-vyGp6PvFo4RvsFtPoIWeCReyIC8");
    headers_4.put("Sec-Fetch-Dest", "empty");
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
    headers_5.put("If-Modified-Since", "Tue, 17 Jan 2023 09:19:30 GMT");
    headers_5.put("If-None-Match", "W/\"2d0-185bf06c4d0\"");
    headers_5.put("Sec-Fetch-Dest", "manifest");
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
    headers_6.put("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJTR19ta2lla1lkQnhvalRBRjN0NzA2SGxMRnRaTzJWNE1aMEkycWRUVWFNIn0.eyJleHAiOjE2NzQ5ODY3NTcsImlhdCI6MTY3NDk0MzU1OCwiYXV0aF90aW1lIjoxNjc0OTQzNTU3LCJqdGkiOiIxYmRhNGEwYi1lZmFmLTQ3YTgtOTc0OC1mMmU2NmViNjkzNmYiLCJpc3MiOiJodHRwczovL2Rldi1rYy5zaW5nbGV3aW5kb3cuaW8vYXV0aC9yZWFsbXMvYWdzdyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJlZWQzYmIzYi1hYWYwLTQ1NGQtYjA1OC00OTczMDg1MTI0MWIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcm9kdWN0LWNhdGFsb2ciLCJzZXNzaW9uX3N0YXRlIjoiNzNlY2M0MTAtY2Q0ZS00ZDVlLWIxM2QtYmJhNDQyODlkMmVkIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwczovL2Rldi10YXJpZmUuc2luZ2xld2luZG93LmlvIiwiaHR0cHM6Ly90ZXN0LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHBzOi8vZGV2LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHA6Ly9sb2NhbGhvc3Q6MzAwMSJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgcHJvZHVjdC1jYXRhbG9nLXNjcCBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IktlbmFuIEfDvGxlciIsInByZWZlcnJlZF91c2VybmFtZSI6ImtlbmFuLmd1bGVyQGRjcy5jb20iLCJnaXZlbl9uYW1lIjoiS2VuYW4iLCJsb2NhbGUiOiJlbiIsImZhbWlseV9uYW1lIjoiR8O8bGVyIiwiZW1haWwiOiJrZW5hbi5ndWxlckBkY3MuY29tIiwiZ3JvdXAiOlsiL2xlZGdlciIsIi90YXJpZmYiXX0.sIQAIRmP2BqEHL6ZBHHNKkDb03e9gWcy09mfC5D5t6YMryiRTnKN9U2cbPgWhuNphMfxVn_BLSZnvIQO1DPFV0J8Lz6YuU3b8sTK3AJzQwqgz18yHKrZT6N-riP4Ru1zjsynB_eQ1Uc0fqXr1uvcH4fomWlVMkLSuD_tOOrVbSApUxvgI-SVlbHd3flLu5MrAI3_ZQzrBpzb5uFGhyRDZDlLwvfxkNam83cEK_x0fz16HeFFVvRKfAvk2dqAGTfpD-mQ3tbuPddBCGSto7zIq_x3pEG_3cby5tH_7OqoeTuuCmtFKv95W_-szSgwilzmTexXgKkYSYhd6iEs3ENjug");
    headers_6.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_6.put("sec-ch-ua-mobile", "?0");
    headers_6.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("Accept", "*/*");
    headers_7.put("Accept-Encoding", "gzip, deflate, br");
    headers_7.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_7.put("Access-Control-Request-Headers", "authorization");
    headers_7.put("Access-Control-Request-Method", "GET");
    headers_7.put("Origin", "https://dev-productcatalog.singlewindow.io");
    headers_7.put("Sec-Fetch-Dest", "empty");
    headers_7.put("Sec-Fetch-Mode", "cors");
    headers_7.put("Sec-Fetch-Site", "same-site");
    headers_7.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_10 = new HashMap<>();
    headers_10.put("Accept", "application/json, text/plain, */*");
    headers_10.put("Accept-Encoding", "gzip, deflate, br");
    headers_10.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_10.put("Origin", "https://dev-productcatalog.singlewindow.io");
    headers_10.put("Sec-Fetch-Dest", "empty");
    headers_10.put("Sec-Fetch-Mode", "cors");
    headers_10.put("Sec-Fetch-Site", "same-site");
    headers_10.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_10.put("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJTR19ta2lla1lkQnhvalRBRjN0NzA2SGxMRnRaTzJWNE1aMEkycWRUVWFNIn0.eyJleHAiOjE2NzQ5ODY3NTcsImlhdCI6MTY3NDk0MzU1OCwiYXV0aF90aW1lIjoxNjc0OTQzNTU3LCJqdGkiOiIxYmRhNGEwYi1lZmFmLTQ3YTgtOTc0OC1mMmU2NmViNjkzNmYiLCJpc3MiOiJodHRwczovL2Rldi1rYy5zaW5nbGV3aW5kb3cuaW8vYXV0aC9yZWFsbXMvYWdzdyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJlZWQzYmIzYi1hYWYwLTQ1NGQtYjA1OC00OTczMDg1MTI0MWIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcm9kdWN0LWNhdGFsb2ciLCJzZXNzaW9uX3N0YXRlIjoiNzNlY2M0MTAtY2Q0ZS00ZDVlLWIxM2QtYmJhNDQyODlkMmVkIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwczovL2Rldi10YXJpZmUuc2luZ2xld2luZG93LmlvIiwiaHR0cHM6Ly90ZXN0LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHBzOi8vZGV2LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHA6Ly9sb2NhbGhvc3Q6MzAwMSJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgcHJvZHVjdC1jYXRhbG9nLXNjcCBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IktlbmFuIEfDvGxlciIsInByZWZlcnJlZF91c2VybmFtZSI6ImtlbmFuLmd1bGVyQGRjcy5jb20iLCJnaXZlbl9uYW1lIjoiS2VuYW4iLCJsb2NhbGUiOiJlbiIsImZhbWlseV9uYW1lIjoiR8O8bGVyIiwiZW1haWwiOiJrZW5hbi5ndWxlckBkY3MuY29tIiwiZ3JvdXAiOlsiL2xlZGdlciIsIi90YXJpZmYiXX0.sIQAIRmP2BqEHL6ZBHHNKkDb03e9gWcy09mfC5D5t6YMryiRTnKN9U2cbPgWhuNphMfxVn_BLSZnvIQO1DPFV0J8Lz6YuU3b8sTK3AJzQwqgz18yHKrZT6N-riP4Ru1zjsynB_eQ1Uc0fqXr1uvcH4fomWlVMkLSuD_tOOrVbSApUxvgI-SVlbHd3flLu5MrAI3_ZQzrBpzb5uFGhyRDZDlLwvfxkNam83cEK_x0fz16HeFFVvRKfAvk2dqAGTfpD-mQ3tbuPddBCGSto7zIq_x3pEG_3cby5tH_7OqoeTuuCmtFKv95W_-szSgwilzmTexXgKkYSYhd6iEs3ENjug");
    headers_10.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_10.put("sec-ch-ua-mobile", "?0");
    headers_10.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_28 = new HashMap<>();
    headers_28.put("Accept", "*/*");
    headers_28.put("Accept-Encoding", "gzip, deflate, br");
    headers_28.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_28.put("Sec-Fetch-Dest", "empty");
    headers_28.put("Sec-Fetch-Mode", "cors");
    headers_28.put("Sec-Fetch-Site", "same-origin");
    headers_28.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_28.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_28.put("sec-ch-ua-mobile", "?0");
    headers_28.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_34 = new HashMap<>();
    headers_34.put("Accept", "application/json, text/plain, */*");
    headers_34.put("Accept-Encoding", "gzip, deflate, br");
    headers_34.put("Accept-Language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_34.put("Content-Type", "application/json");
    headers_34.put("Origin", "https://dev-productcatalog.singlewindow.io");
    headers_34.put("Sec-Fetch-Dest", "empty");
    headers_34.put("Sec-Fetch-Mode", "cors");
    headers_34.put("Sec-Fetch-Site", "same-origin");
    headers_34.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    headers_34.put("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJTR19ta2lla1lkQnhvalRBRjN0NzA2SGxMRnRaTzJWNE1aMEkycWRUVWFNIn0.eyJleHAiOjE2NzQ5ODY3NTcsImlhdCI6MTY3NDk0MzU1OCwiYXV0aF90aW1lIjoxNjc0OTQzNTU3LCJqdGkiOiIxYmRhNGEwYi1lZmFmLTQ3YTgtOTc0OC1mMmU2NmViNjkzNmYiLCJpc3MiOiJodHRwczovL2Rldi1rYy5zaW5nbGV3aW5kb3cuaW8vYXV0aC9yZWFsbXMvYWdzdyIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJlZWQzYmIzYi1hYWYwLTQ1NGQtYjA1OC00OTczMDg1MTI0MWIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcm9kdWN0LWNhdGFsb2ciLCJzZXNzaW9uX3N0YXRlIjoiNzNlY2M0MTAtY2Q0ZS00ZDVlLWIxM2QtYmJhNDQyODlkMmVkIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwczovL2Rldi10YXJpZmUuc2luZ2xld2luZG93LmlvIiwiaHR0cHM6Ly90ZXN0LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHBzOi8vZGV2LXByb2R1Y3RjYXRhbG9nLnNpbmdsZXdpbmRvdy5pbyIsImh0dHA6Ly9sb2NhbGhvc3Q6MzAwMSJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgcHJvZHVjdC1jYXRhbG9nLXNjcCBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IktlbmFuIEfDvGxlciIsInByZWZlcnJlZF91c2VybmFtZSI6ImtlbmFuLmd1bGVyQGRjcy5jb20iLCJnaXZlbl9uYW1lIjoiS2VuYW4iLCJsb2NhbGUiOiJlbiIsImZhbWlseV9uYW1lIjoiR8O8bGVyIiwiZW1haWwiOiJrZW5hbi5ndWxlckBkY3MuY29tIiwiZ3JvdXAiOlsiL2xlZGdlciIsIi90YXJpZmYiXX0.sIQAIRmP2BqEHL6ZBHHNKkDb03e9gWcy09mfC5D5t6YMryiRTnKN9U2cbPgWhuNphMfxVn_BLSZnvIQO1DPFV0J8Lz6YuU3b8sTK3AJzQwqgz18yHKrZT6N-riP4Ru1zjsynB_eQ1Uc0fqXr1uvcH4fomWlVMkLSuD_tOOrVbSApUxvgI-SVlbHd3flLu5MrAI3_ZQzrBpzb5uFGhyRDZDlLwvfxkNam83cEK_x0fz16HeFFVvRKfAvk2dqAGTfpD-mQ3tbuPddBCGSto7zIq_x3pEG_3cby5tH_7OqoeTuuCmtFKv95W_-szSgwilzmTexXgKkYSYhd6iEs3ENjug");
    headers_34.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_34.put("sec-ch-ua-mobile", "?0");
    headers_34.put("sec-ch-ua-platform", "macOS");
    
    String uri1 = "https://dev-kc.singlewindow.io/auth/realms/agsw/login-actions/authenticate";
    
    String uri2 = "https://fonts.gstatic.com/s/inter/v12";
    
    String uri3 = "https://fonts.googleapis.com/css2";
    
    String uri5 = "https://dev-tarife-service.singlewindow.io/api/v2-0/tariff-query/public/countries";

    ScenarioBuilder scn = scenario("CreateWorkOrderPerformanceTest")
      .exec(
        http("request_0")
          .post(uri1 + "?session_code=2l50-wum10jfhAPIGFVPZbJ8tumWicp8s1oEtJMhn-I&execution=c4351c58-ada8-4b6b-bd1c-f280081f1bcc&client_id=product-catalog&tab_id=8RIHgE_-pig")
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
              .get("/api/auth/session")
              .headers(headers_4),
            http("request_5")
              .get("/manifest.json")
              .headers(headers_5),
            http("request_6")
              .get("/api/v1-0/users/self")
              .headers(headers_6),
            http("request_7")
              .options(uri5)
              .headers(headers_7),
            http("request_8")
              .get("/api/v1-0/work-orders/created-by-cbu/status-counts")
              .headers(headers_6),
            http("request_9")
              .get("/api/v1-0/notification-receivers/initial-notifications/30")
              .headers(headers_6),
            http("request_10")
              .get(uri5)
              .headers(headers_10),
            http("request_11")
              .get("/api/v1-0/work-orders/status-counts")
              .headers(headers_6),
            http("request_12")
              .get("/api/v1-0/legislation-change/notifications/all?isJustUnreads=false&startDate=2022-12-28T22:05:58.311Z")
              .headers(headers_6)
          )
      )
      .pause(9)
      .exec(
        http("request_13")
          .get("/_next/static/chunks/9708-c01d4e29c5cd4c5e.js")
          .resources(
            http("request_14")
              .get("/_next/static/chunks/4729-94447f90d31e9072.js"),
            http("request_15")
              .get("/_next/static/chunks/957-18b0e10fdca49bd5.js"),
            http("request_16")
              .get("/_next/static/chunks/6621-54654dae52e514c2.js"),
            http("request_17")
              .get("/_next/static/chunks/4200-eb1416cab326e965.js"),
            http("request_18")
              .get("/_next/static/chunks/3940-b92d0a4b9e636903.js"),
            http("request_19")
              .get("/_next/static/chunks/7629-ec60e1980b4f8333.js"),
            http("request_20")
              .get("/_next/static/chunks/3859-89a3723ba043d4e2.js"),
            http("request_21")
              .get("/_next/static/chunks/259-9ff07828abeac31a.js"),
            http("request_22")
              .get("/_next/static/chunks/8095-08aa732898ac16b9.js"),
            http("request_23")
              .get("/_next/static/chunks/5789-d6e0bf8e953e5ec2.js"),
            http("request_24")
              .get("/_next/static/chunks/9681-39a70378db96d4c8.js"),
            http("request_25")
              .get("/_next/static/chunks/3224-17fe6cee664552ff.js"),
            http("request_26")
              .get("/_next/static/chunks/pages/is-emri-01efca004ffae8e2.js"),
            http("request_27")
              .get("/_next/static/css/74c3fd4c3e251588.css"),
            http("request_28")
              .get("/_next/data/vBWm4d3qe0JBBxE_gZoOE/tr/is-emri.json?operationTypeActive=%C4%B0thalat&advisorActive=69")
              .headers(headers_28),
            http("request_29")
              .options(uri5)
              .headers(headers_7),
            http("request_30")
              .get(uri5)
              .headers(headers_10),
            http("request_31")
              .get("/api/v1-0/files/work-order/last-uploaded-excel?clientId=6")
              .headers(headers_6),
            http("request_32")
              .get("/api/v1-0/notification-receivers/initial-notifications/30")
              .headers(headers_6),
            http("request_33")
              .get("/api/v1-0/suppliers/69")
              .headers(headers_6),
            http("request_34")
              .post("/api/v1-0/work-orders/paged/cbu-client-view")
              .headers(headers_34)
              .body(RawFileBody("createworkorderperformancetest/0034_request.json")),
            http("request_35")
              .get("/api/v1-0/legislation-change/notifications/all?isJustUnreads=false&startDate=2022-12-28T22:06:08.356Z")
              .headers(headers_6)
          )
      )
      .pause(3)
      .exec(
        http("request_36")
          .get("/api/v1-0/commodities/current-commodities?measureType=%C4%B0thalat&article=performans&customsBrokerId=4&clientId=69")
          .headers(headers_6)
          .resources(
            http("request_37")
              .get("/api/v1-0/commodities/current-commodity?measureType=%C4%B0thalat&article=performans&customsBrokerId=4&clientId=69")
              .headers(headers_6)
              .check(status().is(404))
          )
      )
      .pause(15)
      .exec(
        http("request_38")
          .post("/api/v1-0/commodities/check-updated")
          .headers(headers_34)
          .body(RawFileBody("createworkorderperformancetest/0038_request.json"))
      )
      .pause(1)
      .exec(
        http("request_39")
          .post("/api/v1-0/work-orders")
          .headers(headers_34)
          .body(RawFileBody("createworkorderperformancetest/0039_request.json"))
          .resources(
            http("request_40")
              .get("/_next/static/chunks/4985-5643e54c9145a343.js"),
            http("request_41")
              .get("/_next/static/chunks/9098-6897a1c956ee6360.js"),
            http("request_42")
              .get("/_next/static/chunks/pages/is-takibi-449666522e50b81d.js"),
            http("request_43")
              .get("/_next/static/css/3415ea5f330c603c.css"),
            http("request_44")
              .get("/_next/data/vBWm4d3qe0JBBxE_gZoOE/tr/is-takibi.json")
              .headers(headers_28),
            http("request_45")
              .options(uri5)
              .headers(headers_7),
            http("request_46")
              .get("/api/v1-0/notification-receivers/initial-notifications/30")
              .headers(headers_6),
            http("request_47")
              .get(uri5)
              .headers(headers_10),
            http("request_48")
              .get("/api/v1-0/legislation-change/notifications/all?isJustUnreads=false&startDate=2022-12-28T22:06:32.129Z")
              .headers(headers_6),
            http("request_49")
              .get("/api/v1-0/work-orders/status-counts")
              .headers(headers_6),
            http("request_50")
              .post("/api/v1-0/work-orders/paged/cbu-client-view")
              .headers(headers_34)
              .body(RawFileBody("createworkorderperformancetest/0050_request.json")),
            http("request_51")
              .get("/api/v1-0/work-orders/created-by-cbu/status-counts")
              .headers(headers_6)
          )
      );

	  setUp(scn.injectOpen(atOnceUsers(100))).protocols(httpProtocol);
  }
}
