if ( -not (Test-Path -LiteralPath 'venv' -PathType Container) ) {
  pip install virtualenv
  virtualenv venv
}
venv\Scripts\activate.bat