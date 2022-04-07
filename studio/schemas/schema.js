import createSchema from 'part:@sanity/base/schema-creator'
import schemaTypes from 'all:part:@sanity/base/schema-type'

import event from './documents/event.js'
import tag from './documents/tag.js'
import attendee from './documents/attendee.js' // not in use yet
import location from './documents/location.js'
import organization from './documents/organization.js'
import person from './documents/person.js'


export default createSchema({
  // We name our schema
  name: 'default',
  types: schemaTypes.concat([
    event,
    tag,
    location,
    person,
    organization,

  ]),
})
