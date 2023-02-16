# Juicy application
Recipe notes application

## Prerequisites 
- Apache Maven 4.0.0-alpha-4
- Java 17.0.6

## Deploying with docker

### From existing image
```bash
docker image pull nykonoleg/jc_im_int20h
docker container run -p your_port:8080 nykonoleg/jc_im_int20h
```

### Manually
```bash
docker build . -t your_image_name
docker container run -p your_port:8080 your_image_name
```

## Deploying with maven
```bash
./mvnw -Dmaven.test.skip=true spring-boot:run
```


