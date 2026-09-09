#!/usr/bin/env bash

BROWSER=$1
ENVIRONMENT=$2
sbt scalafmtAll scalafmtCheckAll scalafmtSbtCheck clean compile -Dbrowser="${BROWSER:=chrome}" -Dbrowser.usePreviousVersion=true -Daccessibility.timeout=5000.millis -Denvironment="${ENVIRONMENT:=local}" -Dbrowser.option.headless=true "testOnly uk.gov.hmrc.ui.specs*" testReport