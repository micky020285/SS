Const PR_ATTACH_MIME_TAG = "http://schemas.microsoft.com/mapi/proptag/0x370E001E"
Const PR_ATTACH_CONTENT_ID = "http://schemas.microsoft.com/mapi/proptag/0x3712001E"
Const PR_ATTACHMENT_HIDDEN = "http://schemas.microsoft.com/mapi/proptag/0x7FFE000B"


Set Outlook = CreateObject("Outlook.Application")
Set Message = Outlook.CreateItem(olMailItem)
Set realAttachment = Message.Attachments.Add("C:\\WORK\\Automation\\SALESFORCE_Automation\\Report\\index.html")
'Set oPA = realAttachment.PropertyAccessor
'oPA.SetProperty PR_ATTACH_MIME_TAG, "image/png"
'oPA.SetProperty PR_ATTACH_CONTENT_ID, "myident" 'change myident for another other image
'attachment = WScript.Arguments.Item(0)
Message.Subject = "Automation Test Result"
Message.HTMLBody = "<html><body>Hi All, <BR><BR><BR> Please find attached Automation test result. <BR><BR> Note:Click on the Detailed Results link to view Automation Results.<BR><BR><!--<table border=""1""  borderColorDark=""#dddddd"" borderColorLight=""#dddddd"" align=""center"" width=""50%""><tr><td align=""center"" colspan=""4"" valign=""center"" style=""height:50px;""><img src=""cid:myident""/></td></tr><tr><td colspan=""4""></td></tr></table>--><table rules=""none"" borderColorDark=""#dddddd"" borderColorLight=""#dddddd"" border=""1"" align=""center"" width=""50%""><tr><td class=""testerDetails"" align=""center"" valign=""center"" style=""height:50px;"" colspan=""4""><font face = ""Times New Roman"" size=""5""><B>Automation Test Results </B></font></td></tr><font face = ""Times New Roman"" size=""2""><tr><td align=""center"" border=""none"" width=""25%""><B>Selenium Machine</B></td><td align=""center"" border=""none"" width=""25%"">XXXXXX</td><td align=""center"" border=""none"" width=""25%""><B>Tester</B></td><td align=""center"" border=""none"" width=""25%""></td></tr><tr><td align=""center"" border=""none"" width=""25%""><B>Platform</B></td><td align=""center"" border=""none"" width=""25%"">xxxxx</td><td align=""center"" border=""none"" width=""25%""><B>Department</B></td><td align=""center"" border=""none"" width=""25%"">XXXX</td></tr><tr><td align=""center"" border=""none"" width=""25%""><B>Product Name </B></td><td align=""center"" border=""none"" width=""25%"">Salesforce</td><td align=""center"" border=""none"" width=""25%""><B>Passed</B></td><td align=""center"" border=""none"" width=""25%"">xxxxx</td></tr><tr><td align=""center"" border=""none"" width=""25%""><B>Build Number</B></td><td align=""center"" border=""none"" width=""25%"">xxxxx</td><td align=""center"" border=""none"" width=""25%""><B>Failed</B></td><td align=""center"" border=""none"" width=""25%"">xxxxx</td></tr><tr><td align=""center"" border=""none"" width=""25%""><B>Test Result</B></td><td align=""center"" border=""none"" width=""25%"">XXXXXX</td><td align=""center"" border=""none"" width=""25%""><B>Error</B></td><td align=""center"" border=""none"" width=""25%"">xxxxx</td></tr><tr><td align=""center"" border=""none"" width=""25%""><B>Detailed Result</B></td><td align=""center"" border=""none"" width=""25%""><a href=""http://www.google.com"">Click here </a></td><td align=""center"" border=""none"" width=""25%""><B>Total</B></td><td align=""center"" border=""none"" width=""25%"">xxxx</td></tr></font></table></font><BR><BR><BR><B><font color=""red"">Bugs will be raised for the failed test cases</font></B></BR><BR><BR><BR><BR>Thanks,<BR>Test Team</body></html>"
Message.Recipients.Add("balamuruganx_sivasubramanian@mcafee.com")
ConstolOriginator = 0
Message.Send
Set Outlook = nothing
Set Message = nothing