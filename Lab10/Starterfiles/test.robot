*** Comments ***
นายพิรัชย์ ชัยรัตน์ 663380223-3 Sec 1

*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${EDGE_DRIVER_PATH}         ${EXECDIR}${/}edgedriver_win64${/}msedgedriver.exe
${Registration_Page}        http://localhost:7272/Lab10/Registration.html
${Registration_Page_Lab3}   http://localhost:7272/Lab3/Registration.html

${FirstName}            Somsri
${LastName}             Sodsai
${Organization}         CS KKU
${Email}                somsri@kkumail.com
${PhoneNo}              081-001-1234
${InvalidPhoneNo}       1234


*** Keywords ***
Open Edge
    ${edge_options}=    Evaluate    sys.modules['selenium.webdriver'].EdgeOptions()    sys
    ${service}=    Evaluate    sys.modules["selenium.webdriver.edge.service"].Service(executable_path=r"${EDGE_DRIVER_PATH}")    sys
    Create Webdriver    Edge    options=${edge_options}    service=${service}
    Set Selenium Speed    0.1

*** Test Cases ***
1. Register Success
    Open Edge
    Go To    ${Registration_Page}
    Input Text    id=firstname    ${FirstName}
    Input Text    id=lastname    ${LastName}
    Input Text    id=organization    ${Organization}
    Input Text    id=email    ${Email}
    Input Text    id=phone    ${PhoneNo}
    Click Button    id=registerButton
    Page Should Contain    Success
    Close Browser

2. Register Success No Organization Info
    Open Edge
    Go To    ${Registration_Page_Lab3}
    Page Should Contain    Event Registration
    Input Text    id=firstname    ${FirstName}
    Input Text    id=lastname    ${LastName}
    Input Text    id=email    ${Email}
    Input Text    id=phone    ${PhoneNo}
    Click Button  id=registerButton
    Page Should Contain    Success
    Close Browser

3. Empty First Name
    Open Edge
    Go To    ${Registration_Page}
    Input Text    id=lastname    ${LastName}
    Input Text    id=organization    ${Organization}
    Input Text    id=email    ${Email}
    Input Text    id=phone    ${PhoneNo}
    Click Button    id=registerButton
    Wait Until Element Is Visible    id=errors    3s
    Element Text Should Be    id=errors    Please enter your first name!!
    Close Browser

4. Empty Last Name
    Open Edge
    Go To    ${Registration_Page}
    Input Text    id=firstname    ${FirstName}
    Input Text    id=organization    ${Organization}
    Input Text    id=email    ${Email}
    Input Text    id=phone    ${PhoneNo}
    Click Button    id=registerButton
    Wait Until Element Is Visible    id=errors    3s
    Element Text Should Be    id=errors    Please enter your last name!!
    Close Browser

5. Empty First Name and Last Name
    Open Edge
    Go To    ${Registration_Page}
    Input Text    id=organization    ${Organization}
    Input Text    id=email    ${Email}
    Input Text    id=phone    ${PhoneNo}
    Click Button    id=registerButton
    Wait Until Element Is Visible    id=errors    3s
    Element Text Should Be    id=errors   Please enter your name!!
    Close Browser

6. Empty Email
    Open Edge
    Go To    ${Registration_Page}
    Input Text    id=firstname    ${FirstName}
    Input Text    id=lastname    ${LastName}
    Input Text    id=organization    ${Organization}
    Input Text    id=phone    ${PhoneNo}
    Click Button    id=registerButton
    Wait Until Element Is Visible    id=errors    3s
    Element Text Should Be    id=errors   Please enter your email!!
    Close Browser

7. Empty Phone Number
    Open Edge
    Go To    ${Registration_Page}
    Input Text    id=firstname    ${FirstName}
    Input Text    id=lastname    ${LastName}
    Input Text    id=organization    ${Organization}
    Input Text    id=email    ${Email}
    Click Button    id=registerButton
    Wait Until Element Is Visible    id=errors    3s
    Element Text Should Be    id=errors   Please enter your phone number!!
    Close Browser

8. Invalid Phone Number
    Open Edge
    Go To    ${Registration_Page}
    Input Text    id=firstname    ${FirstName}
    Input Text    id=lastname    ${LastName}
    Input Text    id=organization    ${Organization}
    Input Text    id=email    ${Email}
    Input Text    id=phone    ${InvalidPhoneNo}
    Click Button    id=registerButton
    Wait Until Element Is Visible    id=errors    3s
    Element Text Should Be    id=errors   Please enter a valid phone number, e.g., 081-234-5678, 081 234 5678, or 081.234.5678)
    Close Browser