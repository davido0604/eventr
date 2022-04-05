export default {
   title: 'Speakers',
   name: 'speakers',
   type: 'document',
   fields: [
      {
         title: 'Name',
         name: 'name',
         type: 'string',
      },
      {
         title: 'Organization',
         name: 'organization',
         type: 'array',
         of: [{
            type: 'reference',
            to: [{type: 'organization'}], 
         }]
      },
   ]
}