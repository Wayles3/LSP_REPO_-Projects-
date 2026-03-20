# CRC Card Design Explanation

## Why does TaskManager collaborate with Task, but Task does not collaborate with TaskManager?

TaskManager is responsible for storing, finding, and organizing Task
objects, so it naturally needs to reference and interact with Task
directly. Task, on the other hand, only manages its own data — its ID,
description, and status — and has no need to know about the collection
that holds it. This one-way relationship keeps Task simple and
self-contained, while TaskManager handles the broader coordination.