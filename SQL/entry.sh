#!/bin/sh

psql -f job/job.sql -U yagi2
psql -f job/jobtype.sql -U yagi2

psql -f item/itemcategory.sql -U yagi2
psql -f item/item_init.sql -U yagi2

psql -f item/stormblood/4.0/item_c_50.sql -U yagi2
psql -f item/stormblood/4.0/item_c_52.sql -U yagi2
psql -f item/stormblood/4.0/item_c_53.sql -U yagi2
psql -f item/stormblood/4.0/item_c_55.sql -U yagi2
psql -f item/stormblood/4.0/item_c_56.sql -U yagi2
psql -f item/stormblood/4.0/item_c_59.sql -U yagi2
