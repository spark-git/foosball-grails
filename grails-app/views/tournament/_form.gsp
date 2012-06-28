<%@ page import="com.dnb.foosball.Tournament" %>



<div class="fieldcontain ${hasErrors(bean: tournamentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="tournament.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${tournamentInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tournamentInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="tournament.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${tournamentInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: tournamentInstance, field: 'deadlineDate', 'error')} required">
	<label for="deadlineDate">
		<g:message code="tournament.deadlineDate.label" default="Deadline Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="deadlineDate" precision="day"  value="${tournamentInstance?.deadlineDate}"  />
</div>

