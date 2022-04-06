export default {
   title: 'Speaker',
   name: 'speaker',
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