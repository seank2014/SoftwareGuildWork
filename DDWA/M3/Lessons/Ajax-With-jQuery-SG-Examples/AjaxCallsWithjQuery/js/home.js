$(document).ready(function(){
	
	//Get all contacts ajax calls


    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/contacts',
        success: function(contactArray) {
            // get a reference to the 'allContacts' div
            var contactsDiv = $('#allContacts');

            // go through each of the returned contacts and append the info to the
            //contactsDiv
            $.each(contactArray, function(index, contact) {
                var contactInfo = '<p>';
                contactInfo += 'Name: ' + contact.firstName + ' ' + contact.lastName + '<br>';
                contactInfo += 'Company: ' + contact.company + '<br>';
                contactInfo += 'Email: ' + contact.email + '<br>';
                contactInfo += 'Phone: ' + contact.phone + '<br>';
				contactInfo += '</p>';
                contactInfo += '<hr>';

                contactsDiv.append(contactInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    });

    $('#add-button').on('click', function() {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/contact',
            data: JSON.stringify({
                firstName: $('#add-first-name').val(),
                lastName: $('#add-last-name').val(),
                company: $('#add-company').val(),
                phone: $('#add-phone').val(),
                email: $('#add-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
			//code is successful, run this
            success: function(contact) {
                // get a reference to the 'newContact' div
                var newContactDiv = $('#newContact');

                // append contact info to the newContact div
                var contactInfo = '<p>';
                contactInfo += 'Name: ' + contact.firstName + ' ' + contact.lastName + '<br>';
                contactInfo += 'Company: ' + contact.company + '<br>';
                contactInfo += 'Email: ' + contact.email + '<br>';
                contactInfo += 'Phone: ' + contact.phone + '<br>';
				contactInfo += '</p>';
                contactInfo += '<hr>';

                newContactDiv.append(contactInfo);

            },
			//if fails, run this
            error: function() {
                alert('FAILURE');
            }
        });

    });

})
