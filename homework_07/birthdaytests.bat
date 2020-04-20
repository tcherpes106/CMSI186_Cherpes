del testresults.txt
# ============================================================================
# filename: birthdaytests.bat
# purpose: provide a unified test sequence for the BirthdaySolver program
# ============================================================================

echo "running BirthdaySolver test harness for evaluation....." >> testresults.txt
echo ========================================================= >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 0 args
echo Running BirthdaySolver with 0 args >> testresults.txt
java BirthdaySolver >> testresults.txt

echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 3 args
echo Running BirthdaySolver with 3 args >> testresults.txt
java BirthdaySolver 46 52 12 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 0
echo Running BirthdaySolver with 0 >> testresults.txt
java BirthdaySolver 0 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 1
echo Running BirthdaySolver with 1 >> testresults.txt
java BirthdaySolver 1 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 2
echo Running BirthdaySolver with 2 >> testresults.txt
java BirthdaySolver 2 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 25
echo Running BirthdaySolver with 25 >> testresults.txt
java BirthdaySolver 25 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 50
echo Running BirthdaySolver with 50 >> testresults.txt
java BirthdaySolver 50 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with -50
echo Running BirthdaySolver with -50 >> testresults.txt
java BirthdaySolver -50 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 100 2
echo Running BirthdaySolver with 100 2 >> testresults.txt
java BirthdaySolver 100 2 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 100 0
echo Running BirthdaySolver with 100 0 >> testresults.txt
java BirthdaySolver 100 0 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 100 3000000
echo Running BirthdaySolver with 100 3000000 >> testresults.txt
java BirthdaySolver 100 3000000 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 50 -1
echo Running BirthdaySolver with 50 -1 >> testresults.txt
java BirthdaySolver 50 -1 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with banana smoothie
echo Running BirthdaySolver with banana smoothie  >> testresults.txt
java BirthdaySolver banana smoothie >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 73 50
echo Running BirthdaySolver with 73 50 >> testresults.txt
java BirthdaySolver 73 50 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 39.8 100
echo Running BirthdaySolver with 39.8 100 >> testresults.txt
java BirthdaySolver 39.8 100 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 398 10.5
echo Running BirthdaySolver with 398 10.5 >> testresults.txt
java BirthdaySolver 398 10.5 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with -1 -1
echo Running BirthdaySolver with -1 -1 >> testresults.txt
java BirthdaySolver -1 -1 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 3 -0
echo Running BirthdaySolver with 3 -0 >> testresults.txt
java BirthdaySolver 3 -0 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 29 75
echo Running BirthdaySolver with 29 75 >> testresults.txt
java BirthdaySolver 29 75 >> testresults.txt
echo ========================================================= >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo Running BirthdaySolver with 123 321
echo Running BirthdaySolver with 123 321 >> testresults.txt
java BirthdaySolver 123 321 >> testresults.txt
