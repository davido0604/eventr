export default {
   title: "Organization",
   name: "organization",
   type: "document",
   fields: [
      {
         title: "Name",
         name: "name",
         type: "string",
         validation: (Rule) => Rule.required().error("This field is required"),
      },
      {
         name: "email",
         title: "Email",
         type: "string",
         /*regex retrieved from this website:
         https://www.erichowey.dev/writing/validation-snippets-for-sanity-io/
         uses built in validation method regex for string schema types to
         check if an email contains @ (does not seem to check for dot).
         */
         validation: (Rule) =>
            Rule.regex(
               /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/,
               {
                  name: "email", // Error message is "Does not match email-pattern"
               }
            ),
      },
   ],
};
