#gradle sonarqube -Dsonar.host.url=localhost -Dsonar.verbose=true
gradle sonarqube -Dsonar.host.url=http://localhost -Dsonar.verbose=true
docker run -d --name sonarqube -p 9000:9000 <image_name>