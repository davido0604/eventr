export default {
   title: 'Person',
   name: 'person',
   type: 'document',
   fields: [
      {
         title: 'Name',
         name: 'name',
         type: 'string',
         validation: Rule => Rule.required().error('This field is required')
      },
      {
         title: 'Organization',
         name: 'organization',
         type: 'string',
         of: [{
            type: 'reference',
            to: [{type: 'organization'}], 
         }]
      },
   ]
}