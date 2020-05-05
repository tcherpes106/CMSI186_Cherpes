@del clocktestresults.txt

# ============================================================================
# filename: clocktest.bat
# purpose: provide a unified test sequence for the ClockSolver program
# ============================================================================

echo "running ClockSolver test harness for evaluation....." >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt


java ClockSolver banana smoothie >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver hours minutes seconds >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver ::: >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 1:2:3 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 1a:2b:3c >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 11:22:33 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 00:00:00 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 12:34:56 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 10:20:30 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 99:99:99 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 24:60:60 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 23:59:59 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 12:59:34 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 08:23:47 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 17:38:00 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver Hi:Professor:Johnson >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 11:11:11 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 16:51:27 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 23:59:59 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 20:45:35 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 12:12:12 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 01:20:03 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 05:28:49 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 09:59:31 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
java ClockSolver 04:15:00 >> clocktestresults.txt
echo . >> clocktestresults.txt
echo ========================================================= >> clocktestresults.txt
