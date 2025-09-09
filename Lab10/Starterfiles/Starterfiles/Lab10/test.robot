*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${EDGE_DRIVER_PATH}    C:\Users\computer\Downloads\edgedriver_win64\msedgedriver.exe
${HOMEPAGE}    http://www.google.com
${BROWSER}    Edge

*** Test Cases ***
Go To homepage
    Open Browser    ${HOMEPAGE}    ${BROWSER}