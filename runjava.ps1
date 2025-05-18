$filepath = $args[0]
if ($filepath -eq $null) {
    Write-Host "Please provide a filepath as an argument."
    exit
}
$name = [System.IO.Path]::GetFileNameWithoutExtension($filepath)
javac $filepath -d .
java $name
Get-ChildItem -Path . -Filter *.class -Recurse | Remove-Item -Force