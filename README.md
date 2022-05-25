# Inference-Engine
Intro To AI COS30019 Assignment 2


Student details
- Joel wyn TAN (662443x)

Progression
- Read_file : implementation using scanner, taking the file correctly and splitting into clauses, facts
- horn : taking the clauses from read_file then split into left side = listA, right side = arrow.
- forward chaining: implementation work without problem, but added a safeguard to check against duplicate where bc gave error.
- backward chaining: got initial implementation work with the test file from the unit but it will list out in the same way as forward due to using a positif for loop, changing to -- gave us the right out. Also found bugs due to duplicate when testing different input data, fixed the bugs by using .contain() to check if the new adding element exist in the container.
-truth table: working correctly, found bugs due to duplicate as well like backward chaining and using .contain() to fix the duplicats problem.


Test:

Case# 1 (from the unit attachments)
Tell: p2=> p3; p3 => p1; c => e; b&e => f; f&g => h; p1=>d; p1&p3 => c; a; b; p2;
Ask : d

FC output: YES: a,b,p2,p3,p1,d
BC output: YES: p2,p3,p1,d
truth output: Yes: 3

feedback: output from 3 methods is correct

Case#2 (simple data)

Tell: a => b; b =>c; c => d; a;
Ask : d

FC output: YES: a,b,c,d
BC output: YES: a,b,c,d
truth output: Yes: 1

feedback: output from 3 methods is all correct;

Case#3
Tell: a&b=>d; b=>c; c&a=>d; b&d=>e; c&e=>f; d=>b; a; c;
Ask : f

FC output: YES: a,c,d,b,d,e,c,f
BC output: infiniti loop due to duplicate clauses. Added .contain check before adding to avoid duplicate and bug fixed.
**BC output: YES: a,d,b,e,c,f
truth output: Yes: 1



