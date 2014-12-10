<%@page import="com.rknowsys.eapp.hrm.service.PimDisplayGroupsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PimDisplayGroups"%>
<%@page import="com.rknowsys.eapp.hrm.service.PimCriteriaSelectionLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PimCriteriaSelection"%>
<%@page import="com.rknowsys.eapp.hrm.model.Language"%>
<%@page import="com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Skill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/html/pimreports/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addreport</title>
<portlet:actionURL var="savepimreport" name="savePimReport">
</portlet:actionURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/pimreports/list.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="dependencyDropdown" id="dependencyDropdown"/>
<style type="text/css">
.aui input[type="text"],.aui select{
border-radius: 4px;
}
.aui label {
color: #555;
font-size: 14px;
font-weight: 200;
font-family: sans-serif;
font: small-caption;
}
</style>
<aui:script>

AUI().ready('event', 'node', function(A){
   A.one('#skillField').hide();
   A.one('#skillControl').hide();
    A.one('#languageField').hide();
   A.one('#languageControl').hide();
  
 });
AUI().use(
  'aui-node',
  function(A) {
     var criteriaArray = []; var displayfieldsArray = []; var displayfieldsNamesArray = [];
     
    var node = A.one('#addselector');
    node.on(
      'click',
      function() {
     
     AUI().ready('aui-node',function(A) {
      A.all('#criteria-list option:selected').each(function() {
          this.remove();
          var x = this.val();
         criteriaArray.push(x);
        A.one('#selectedCriteriaFields').set("value",criteriaArray.toString());
          if(x==96503){
          A.one('#skillField').show();
          A.one('#skillControl').show();
          A.one('#skilldeleteMark').show();
        }
        if(x==96501)
        {
           A.one('#languageField').show();
           A.one('#languageControl').show();
           A.one('#languagedeleteMark').show();
        }
         
    });
    
      });
       
      }
    );
    var displaynode = A.one('#displayselector');
    displaynode.on(
      'click',
      function() {
     var x =  A.one('#<portlet:namespace/>pimdisplayfields').val();
      var y =  A.one('#<portlet:namespace/>pimdisplayfields option:selected').text();
      displayfieldsArray.push(x);
      displayfieldsNamesArray.push(y);
      A.one('#displayfieldsselected').appendChild('<p id="appendedvalue"><a href="#" onclick="javascript:deleteField()"  style="color: red">X</a><span  id="selectedvalue"> '+y+' </span><input type="hidden" value=""> </p>');
      A.one('#<portlet:namespace/>pimdisplayfields option').remove(y);
       A.one('#selectedDisplayFields').set("value",displayfieldsArray.toString());
      }
    );
    
    var node = A.one('#skilldeleteMark');
    node.on(
      'click',
      function() {
  		 A.one('#skilldeleteMark').hide();
        A.one('#skillField').hide();
        A.one('#skillControl').hide();
        A.one('#criteria-list').append('<option value="96503">Skill</option>');
        var i = criteriaArray.indexOf('96503');
       if(i>-1){
        criteriaArray.splice(i,1);
       }
       
        A.one('#selectedCriteriaFields').set("value",criteriaArray.toString());
       
      }
    );
    
  var node = A.one('#languagedeleteMark');
    node.on(
      'click',
      function() {
      
        A.one('#languageField').hide();
        A.one('#languageControl').hide();
        A.one('#languagedeleteMark').hide();
        A.one('#criteria-list').append('<option value="96501">Language</option>');
         var i = criteriaArray.indexOf('96501');
       if(i>-1){
        criteriaArray.splice(i,1);
       }
       A.one('#selectedCriteriaFields').set("value",criteriaArray.toString());
       
      }
    );
    

var A=new AUI();
A.ready(function(){
window.dropdowns= function(nodeValue)
         {
        		var currencyDropDown=nodeValue;
        var targetElement = A.one("#<portlet:namespace />pimdisplayfields");
		var url = '<%=dependencyDropdown%>';
         A.io.request(url,
        	 {
		 data: {  
		       <portlet:namespace />dropDownValue: currencyDropDown,  
		       },
		 dataType:'json',
		 on: {
		       success: function() {
		        var nameslist = [];
		          var idlist = [];
		          var list = [];var tablelist = [];var columnlist = [];
		         var responseArray=this.get('responseData');
		         
		          for(var i =0;i< responseArray.length;i++)
		          {
		            list = responseArray[i].split(",");
		          		           
		            nameslist.push(list[0]);
		        
		            idlist.push(list[1]);
		            
		            tablelist.push(list[2]);
		            
		            columnlist.push(list[3]);
		         
		          }
		          for(var i =0;i< displayfieldsArray.length;i++)
					{
					    var id = displayfieldsArray[i];
					  var k = idlist.indexOf(id);	
					  if(k>-1)
					  {
					    idlist.splice(k,1);
					  }
					}
					
				  for(var j=0; j< displayfieldsNamesArray.length;j++)
				  {
				    var name = displayfieldsNamesArray[j];
				  var l = nameslist.indexOf(name);
				   if(l> -1)
				    {
				     nameslist.splice(l,1);
				    }
				  }		          
		          targetElement.html("");
		          for (var j=0; j < nameslist.length; j++) {
		          
		          targetElement.append("<option value='" + idlist[j] + "'>" + nameslist[j] + "</option>");
		                    }
                           },
                      failure: function() {
                          }
               }
             });
		
           };
           
window.deleteField= function(){
var x = A.one('#selectedvalue').text();
var value = A.one('#appendedvalue');
A.one('#displayfieldsselected').removeChild(value);


}
           
           
        });
 }
);
     
</aui:script>
</head>
<body>
<aui:form action="<%=savepimreport.toString()%>">
<div class="row-fluid">
<div class="span2"><label>Report Name</label> </div>
<div class="span4">
<aui:input name="reportName" id="reportName" label="" inlineLabel="left" showRequiredLabel="false"><aui:validator name="required" errorMessage="Report Name Required"></aui:validator> </aui:input>
</div><div class="span6"></div>
</div>
<hr/>
<div class="row-fluid">
<div class="span2"><label>Selection Criteria</label> </div>
<div class="span3">
<%
					List<PimCriteriaSelection> criteriaSelectionsList  = PimCriteriaSelectionLocalServiceUtil.getPimCriteriaSelections(-1, -1);
						System.out.println("List == " + criteriaSelectionsList.size());
				%>
				<select name="<portlet:namespace />skilllist" id="criteria-list">
					<%
						for (int i = 0; i < criteriaSelectionsList.size(); i++) {
					%>

					 <Option value="<%=criteriaSelectionsList.get(i).getCriteriaSelectionId()%>"><%=criteriaSelectionsList.get(i).getCriteriaSelectionName()%></Option> 
					<%
						}
					%>
				</select>


</div><div class="span1"><a id="addselector" href="#">Add</a></div>
<div class="span6">
<input type="hidden" id="selectedCriteriaFields" name="<portlet:namespace/>selectedCriteriaFields">
</div>
</div>
<hr/>
<div class="row-fluid">
<div class="span2"><label>Selected Criteria</label> </div>
<div class="span4"></div>	
<div class="span6"></div>

</div>
<div class="row-fluid">
<div class="span2"><label>Include</label> </div>
<div class="span4">
<aui:select name="includeEmployees" label="" id="status">
<aui:option value="Current Employees Only">Current Employees Only</aui:option>
<aui:option value="Current and Past Employees">Current and Past Employees</aui:option>
<aui:option value="Past Employees Only">Past Employees Only</aui:option>

</aui:select>

</div>
<div class="span6">
</div>

</div>
<div class="row-fluid">
<div class="span2" id="languageField"><label>Language</label><a href="#" id="languagedeleteMark" style="color: red">X</a>  </div>
<div class="span4" id="languageControl">
 <%
					List<Language> languageList = LanguageLocalServiceUtil.getLanguages(-1, -1);
						System.out.println("List == " + languageList.size());
				%>
				<select name="<portlet:namespace />languagelist" id="language-list">
					<%
						for (int i = 0; i < languageList.size(); i++) {
					%>

					 <Option value="<%=languageList.get(i).getLanguageId()%>"><%=languageList.get(i).getLanguageName()%></Option> 
					<%
						}
					%>
				</select>

</div>
<div class="span6"></div>

</div>
<div class="row-fluid">
<div class="span2" id="skillField"><label>Skill</label><a href="#" id="skilldeleteMark" style="color: red">X</a>  </div>
<div class="span4" id="skillControl">
 <%
					List<Skill> skillList = SkillLocalServiceUtil.getSkills(0, 10);
						System.out.println("List == " + skillList.size());
				%>
				<select name="<portlet:namespace />skilllist" id="skills-list">
					<%
						for (int i = 0; i < skillList.size(); i++) {																		
					%>

					<Option value="<%=skillList.get(i).getSkillId()%>"><%=skillList.get(i).getSkillName()%></Option>
					<%
						}
					%>
				</select>

</div>
<div class="span6"></div>

</div>



<hr/>
<div class="row-fluid">
<div class="span2"><label>Display Field Groups</label> </div>
<div class="span3">

  <%
					List<PimDisplayGroups> groupList = PimDisplayGroupsLocalServiceUtil.getPimDisplayGroupses(-1, -1);
						System.out.println("List == " + groupList.size());
				%>
				<select name="<portlet:namespace />tableList" id="table-List" onchange="dropdowns(this.value)">
					<%
						for (int i = 0; i < groupList.size(); i++) {
					%>

					<Option value="<%=groupList.get(i).getDiplayGroupId()%>"><%=groupList.get(i).getDisplayGroupName()%></Option>
					<%
						}
					%>
				</select>



</div>
<div class="span1"><a id="" href="#">Add</a></div>
<div class="span6"></div>		

</div>
<div class="row-fluid">
<div class="span2"><label>Display Fields</label> </div>
<div class="span3">
<aui:select name="pimdisplayfields" label="" id="pimdisplayfields">
</aui:select>


</div>
<div class="span1" ><a id="displayselector" href="#">Add</a></div>
<div class="span6"></div>

</div>
<hr/>
<div class="row-fluid">
<div class="span2"><label>Display Fields</label> </div>
<div class="span4">
<span id=""></span>
</div>
<div class="span6">
<input type="hidden" id="selectedDisplayFields" name="<portlet:namespace/>selectedDisplayFields">
</div>

</div>
<div class="row-fluid">
<div class="span4" id="displayfieldsselected" >

</div>
<div class="span4"></div>
<div class="span4"></div>

</div> 
<hr/>
<aui:button type="submit" value="Save"></aui:button><aui:button type="button" value="Cancel" onClick="<%=listview.toString()%>"></aui:button>
</aui:form>

 
 
</body>
</html>