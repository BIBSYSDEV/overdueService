set MAVEN_OPTS=-Xms64m -Xmx256m -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=19391,server=y,suspend=n
mvn -npu -Djetty.http.port=9390 jetty:run