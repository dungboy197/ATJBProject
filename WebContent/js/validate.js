function validate() {

   var firstName = document.myForm.FirstName.value;
   var lastName  = document.myForm.LastName.value;
   var telephone = document.myForm.Telephone.value;
   var email     = document.myForm.Email.value;
   var Des       = document.myForm.Des.value;
   var youAreIn  = document.myForm.YouAreIn.value;
   const re      = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
   
         if( firstName == "" || !isNaN(firstName) || firstName.length > 20 ) {
            alert( "FirstName error!" );
            document.myForm.FirstName.focus() ;
            return false;
         }
         if( lastName == "" || !isNaN(lastName) || lastName.length > 20 ) {
            alert( "LastName error!" );
            document.myForm.LastName.focus() ;
            return false;
         }
         if( isNaN(telephone) || telephone.length > 11 ) {
            alert( "Telephone error!" );
            document.myForm.Telephone.focus() ;
            return false;
         }
         if( email.length > 50 || !re.test(String(email).toLowerCase())) {
            alert( "Email error!" );
            document.myForm.Email.focus() ;
            return false;
         }
         if( youAreIn == "" ) {
            alert( "Please provide your are in!" );
            return false;
         }

         return( true );
      }