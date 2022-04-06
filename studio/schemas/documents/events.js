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
         title: 'Price',
         name: 'price',
         type: 'string',
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
         title: 'Start date and time',
         name: 'StartDateAndTime',
         type: 'datetime',
         options: {
            dateFormat: 'DD-MMM-YYYY',
            timeFormat: 'HH:mm',
            calenderTodatLabel: 'Today'
         }
      },
      {
         title: 'End date and time',
         name: 'EndDateAndTime',
         type: 'datetime',
         options: {
            dateFormat: 'DD-MMM-YYYY',
            timeFormat: 'HH:mm',
            calenderTodatLabel: 'Today'
         }
      },
   ]
}