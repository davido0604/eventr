export default {
   title: 'Events',
   name: 'events',
   type: 'document',
   fields: [
      {
         title: 'Title',
         name: 'title',
         type: 'string',
      },
      {
         title: 'Slug',
         name: 'slug',
         type: 'slug',
         options: {
            source: 'title'
         },
      },
      {
         title: 'Description',
         name: 'description',
         type: 'text',
      },
      {
         title: 'Picture',
         name: 'picture',
         type: 'image',
         options: {
            hotspot: true // redigering inni sanity
         }
      },
      {
         title: 'Tags',
         name: 'tags',
         type: 'array',
         of: [{
            type: 'reference',
            to: [{type: 'tags'}], 
         }]
         // referer til andre dokumenter via dropdown menu
      },
      {
         title: 'Date',
         name: 'date',
         type: 'date',
         options: {
            dateFormat: 'DD-MMM-YYYY',
            calenderTodatLabel: 'Today'
         }
      }
   ]
}