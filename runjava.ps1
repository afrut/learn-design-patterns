$filepath = $args[0]
if ($filepath -eq $null) {
    Write-Host "Please provide a filepath as an argument."
    exit
}
$dir = [System.IO.Path]::GetDirectoryName($filepath)
$cwd = Get-Location
$main_filepath = $filepath
$main_filename = [System.IO.Path]::GetFileName($filepath)
$main_name = [System.IO.Path]::GetFileNameWithoutExtension($filepath)
Set-Location $dir
javac -d . *.java
java $main_name
Get-ChildItem -Path . -Filter *.class -Recurse | Remove-Item -Force
Set-Location $cwd