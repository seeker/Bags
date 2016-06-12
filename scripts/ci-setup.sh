#!/bin/sh

# Download the latest buildtool
wget https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar

# TODO use maven or environment variable to set revision
# generate the dependencies
java -jar BuildTools.jar --rev 1.9