#!/bin/sh

psql -f job/job.sql -U yagi2
psql -f job/jobtype.sql -U yagi2
psql -f item/itemcategory.sql -U yagi2
psql -f item/stormblood/4.0.sql -U yagi2