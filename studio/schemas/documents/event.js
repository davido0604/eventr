export default {
   title: 'Event',
   name: 'event',
   type: 'document',
   fields: [
      {
         title: 'Title',
         name: 'title',
         type: 'string',
         validation: Rule => Rule.required().error('This field is required')
      },
      {
         title: 'Description',
         name: 'description',
         type: 'text',
      },
      {
         title: 'Location',
         name: 'location',
         type: 'array',
         of: [{
            type: 'reference',
            to: [{type: 'location'}], 
         }],
         validation: Rule => Rule.required().error('This field is required')
      },
      {
         title: 'Hosts',
         name: 'hosts',
         type: 'array',
         of: [{
            type: 'reference',
            to: [{type: 'person'}, {type: 'organization'}], 
         }],
         validation: Rule => Rule.required().error('This field is required')
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
         },
         validation: Rule => Rule.required().warning('Banner picture is recommended')
      },
      {
         title: 'Price',
         name: 'price',
         type: 'number',
         description: 'if the event is free, leave blank'
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
         name: 'startDateAndTime',
         type: 'datetime',
         options: {
            dateFormat: 'DD-MMM-YYYY',
            timeFormat: 'HH:mm',
            timeStep: 15,
            calenderTodatLabel: 'Today'
         }
      },
      {
         title: 'End date and time',
         name: 'endDateAndTime',
         type: 'datetime',
         options: {
            dateFormat: 'DD-MMM-YYYY',
            timeFormat: 'HH:mm',
            timeStep: 15,
            calenderTodatLabel: 'Today'
         }
      },
   ]
}