#!/usr/bin/env bash

VENV_DIRECTORY=venv
if [ ! -d "$VENV_DIRECTORY" ]; then
  python3 -m venv $VENV_DIRECTORY
fi
source venv/bin/activate