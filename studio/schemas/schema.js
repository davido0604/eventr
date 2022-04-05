import createSchema from 'part:@sanity/base/schema-creator'
import schemaTypes from 'all:part:@sanity/base/schema-type'

import events from './documents/events.js'
import tags from './documents/tags.js'
import attendee from './documents/attendee.js'
import location from './documents/location.js'
import organization from './documents/organization.js'
import speakers from './documents/speakers.js'

export default createSchema({
  // We name our schema
  name: 'default',
  types: schemaTypes.concat([
    events,
    tags,
    attendee,
    location,
    speakers,
    organization
  ]),
})
