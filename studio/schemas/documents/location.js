export default {
   title: 'Location',
   name: 'location',
   type: 'document',
   fields: [
      {
         title: 'Venue',
         name: 'venue',
         type: 'string',
         validation: Rule => Rule.required().error('This field is required')
      },
      {
         title: 'Road Address',
         name: 'roadAddress',
         type: 'string',
      },
      {
         title: 'Post Number',
         name: 'postNumber',
         type: 'number',
         validation: Rule => Rule.length(4) // TODO se mer på imorgen
      },
      {
         title: 'City',
         name: 'city',
         type: 'array',
         of: [{ type: 'string'}],
         options: {
            list: [
               {title: 'Oslo', value: 'Oslo' },
               {title: 'Bergen', value: 'Bergen' },
               {title: 'Kristiandsand', value: 'Kristiandsand' },
               {title: 'Fredrikstad', value: 'Fredrikstad' },
               {title: 'Tromsø', value: 'Tromso' },
               {title: 'Null', value: 'Null4' },
            ],
         },
         validation: Rule => Rule.required().error('This field is required')
      },
   ]
}