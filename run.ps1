$name = $args[0]
if ($name -eq $null) {
    Write-Host "Please provide a name as an argument."
    exit
}
javac ./src/$name.java -d .
java $name
Get-ChildItem -Path . -Filter *.class -Recurse | Remove-Item -Force