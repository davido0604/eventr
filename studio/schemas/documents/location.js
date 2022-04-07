export default {
   title: "Location",
   name: "location",
   type: "document",
   fields: [
      {
         title: "Venue",
         name: "venue",
         type: "string",
         validation: (Rule) => Rule.required().error("This field is required"),
      },
      {
         title: "Address",
         name: "address",
         type: "string",
         description: 'only street address, f.ex: "Rosenkrantz gate 16"',
      },
      {
         title: "City",
         name: "city",
         type: "array",
         of: [{ type: "string" }],
         options: {
            list: [
               { title: "Oslo", value: "Oslo" },
               { title: "Bergen", value: "Bergen" },
               { title: "Kristiandsand", value: "Kristiandsand" },
               { title: "Fredrikstad", value: "Fredrikstad" },
               { title: "Tromsø", value: "Tromso" },
            ],
         },
         validation: (Rule) => Rule.required().error("This field is required"),
      },
   ],
};
