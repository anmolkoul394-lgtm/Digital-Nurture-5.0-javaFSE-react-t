# 1. Docker Commands

## Basic commands
```bash
docker run <image>          # create + start a container from an image
docker ps                   # list RUNNING containers
docker ps -a                # list ALL containers (including stopped)
docker stop <container>     # gracefully stop a running container
docker rm <container>       # remove a stopped container
docker images                # list downloaded images
docker rmi <image>           # remove an image
docker pull <image>          # download an image from a registry
```

## docker run variations
```bash
docker run --name my-app nginx                 # run under a specific name
docker run -d nginx                              # detached mode (background)
docker run -it ubuntu bash                        # interactive, with a TTY
docker run -p 8080:80 nginx                        # publish container port 80 as host port 8080
docker run --rm alpine echo "hi"                   # auto-remove container once it exits
docker run -e SPRING_PROFILES_ACTIVE=prod my-app   # append/pass env vars or a command
```

## docker exec — run a command inside a RUNNING container
```bash
docker exec -it my-app bash        # open a shell inside the container
docker exec my-app cat /etc/hosts   # run a one-off command
```
