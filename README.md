# dev-course
[![Build Status](https://travis-ci.org/juliaaano/dev-course.svg)](https://travis-ci.org/juliaaano/dev-course)
[![Release](https://img.shields.io/github/release/juliaaano/dev-course.svg)](https://github.com/juliaaano/dev-course/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/com.dev.course/dev-course.svg)](https://maven-badges.herokuapp.com/maven-central/com.dev.course/dev-course)
[![Javadocs](http://www.javadoc.io/badge/com.dev.course/dev-course.svg?color=blue)](http://www.javadoc.io/doc/com.dev.course/dev-course)

A quick start for the development of new Java applications. :ok_hand:

* Container-ready with **Docker** and Docker Compose configuration.
* Docker **builder** pattern with caching of Maven dependencies.
* Red Hat **OpenShift** container deployment.
* Basic **Kubernetes** deployment and service definitions.
* **Istio** ingress gateway and virtual service definitions.
* **Travis** CI pipeline with automated GitHub releases and Docker build and push.
* **Spark Java's** smart and simple http endpoints.
* Testing with **REST-assured**.
* SLF4J and Logback setup, with per-request log level filter.
* Additional **Log4j2** YAML config with several features.
* Prints ascii banner at application startup.

## Docker
```
docker-compose up
curl -i http://localhost:8000/status
curl -i -X POST http://localhost:8000/api/greeting -d '{"name": "John", "surname":"Smith"}' -H "Content-Type: application/json"
curl -i -X POST http://localhost:8000/api/greeting -d '{"name": "John", "surname":"Smith"}' -H "Content-Type: application/json" -H "X-Request-ID: myCorrelationID" -H "X-Log-Level: DEBUG"
```

## Kubernetes
```
minikube start
eval $(minikube docker-env)
docker build -t juliaaano/dev-course:1.0-SNAPSHOT .
kubectl create namespace my-namespace
kubectl config set-context --current --namespace=my-namespace
kubectl apply -f manifests/
kubectl set image deployment dev-course app=juliaaano/dev-course:1.0-SNAPSHOT
kubectl scale deployment dev-course --replicas 2
kubectl expose deployment dev-course --name=dev-course-lb --type=LoadBalancer --port=8000 --target-port=4567
minikube tunnel
curl "http://localhost:8000/api/hostname"
```

## OpenShift

Login to an existing cluster.

### Build the app with Maven:
```
mvn clean package -DskipTests
```

### Setup the project/namespace:
```
oc new-project my-project
oc create secret docker-registry my-redhat-credentials \
    --docker-server=registry.redhat.io \
    --docker-username=my-redhat-username \
    --docker-password=my-redhat-password
oc secrets link default my-redhat-credentials --for=pull
oc secrets link builder my-redhat-credentials
```

### Build container image:
```
oc new-build --binary=true --docker-image=registry.redhat.io/ubi8/openjdk-11 --name=dev-course
oc start-build dev-course --from-file ./target/app-1.0-SNAPSHOT.jar --follow
```

### Deployment
```
oc apply -f manifests/
oc set image deployment dev-course app=$(oc get imagestream dev-course -o jsonpath='{.status.dockerImageRepository}')
oc scale deployment dev-course --replicas 3
oc expose service dev-course
curl "http://$(oc get route dev-course -o jsonpath='{.spec.host}')/api/hostname"
```
