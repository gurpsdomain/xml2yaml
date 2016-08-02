# xml2yaml [![Build Status](https://travis-ci.org/gurpsdomain/xml2yaml.svg?branch=master)](https://travis-ci.org/gurpsdomain/xml2yaml)
A tool to converter xml data files into yml data files

## Building
The project relies on [maven][] for building. Running the following command
builds several artifacts. 

```sh
mvn package
```

## Usage
After building the project there is an artifact
`xml2yaml-<VERSION>-jar-with-dependencies.jar` in the `target` directory. This
is an executable jar that can be run with the following command

```sh
java -jar xml2yaml-<VERSION>-jar-with-dependencies.jar <data-file>
```

For ease of use, one can create the following script

```bash
#! /usr/bin/env bash

LOCATION=<INSTALLATION-DIRECTORY>
VERSION=<INSTALLED-VERSION>

java -jar $LOCATION/xml2yaml-$VERSION-jar-with-dependencies.jar "$@"
```

substituting the correct values for `<INSTALLATION-DIRECTORY>` and `<VERSION>`.

[maven]: https://maven.apache.org/
