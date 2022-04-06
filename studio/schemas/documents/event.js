export default {
   title: 'Event',
   name: 'event',
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
         title: 'Location',
         name: 'location',
         type: 'string',
         of: [{
            type: 'reference',
            to: [{type: 'location'}], 
         }]
      },
      {
         title: 'Hosts',
         name: 'hosts',
         type: 'array',
         of: [{
            type: 'reference',
            to: [{type: 'person'}, {type: 'organization'}], 
         }]
      },
      {
         title: 'Speakers',
         name: 'speakers',
         type: 'array',
         of: [{
            type: 'reference',
            to: [{type: 'person'}], 
         }]
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
            to: [{type: 'tag'}], 
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