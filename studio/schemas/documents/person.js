export default {
   title: 'Person',
   name: 'person',
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
         type: 'string',
         of: [{
            type: 'reference',
            to: [{type: 'organization'}], 
         }]
      },
   ]
}