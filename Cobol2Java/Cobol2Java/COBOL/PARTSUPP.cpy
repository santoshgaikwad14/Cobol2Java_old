       01  PART-SUPP-ADDR-PO.
           05 PARTS.
               10  PART-NUMBER       PIC X(23) VALUE SPACES. *> 01-23
               10  PART-NAME         PIC X(14) VALUE SPACES. *> 24-37
               10  SPEC-NUMBER       PIC X(07) VALUE SPACES. *> 38-44
               10  GOVT-COMML-CODE   PIC X(01) VALUE SPACES. *> 45-45
               10  BLUEPRINT-NUMBER  PIC X(10) VALUE SPACES. *> 46-55
               10  UNIT-OF-MEASURE   PIC X(03) VALUE SPACES. *> 56-58
               10  WEEKS-LEAD-TIME   PIC 9(03) VALUE ZERO.   *> 59-61
                    88 WEEKS-LEAD-TIME-OK VALUES 1 THRU 4.
               10  VEHICLE-MAKE      PIC X(03) VALUE SPACES. *> 62-64
                    88 CHRYSLER       VALUE 'CHR'.
                    88 FORD           VALUE 'FOR'.
                    88 GM             VALUE 'GM '.
                    88 VOLKSWAGON     VALUE 'VW '.
                    88 TOYOTA         VALUE 'TOY'.
                    88 JAGUAR         VALUE 'JAG'.
                    88 PEUGEOT        VALUE 'PEU'.
                    88 BMW            VALUE 'BMW'.
               10  VEHICLE-MODEL     PIC X(10) VALUE SPACES. *> 65-74
               10  VEHICLE-YEAR      PIC X(04) VALUE '0000'. *> 75-78
                    88 VEHICLE-YEAR-OK VALUES '1990' THRU '2019'.
               10  FILLER            PIC X(14) VALUE SPACES. *> 79-92
           05 SUPPLIERS.
               10  SUPPLIER-CODE     PIC X(10) VALUE SPACES. *> 93-102
               10  SUPPLIER-TYPE     PIC X(01) VALUE SPACES. *> 103-103
                    88 SUBCONTRACTOR  VALUE 'S'.
                    88 DISTRIBUTOR    VALUE 'D'.
                    88 MANUFACTURER   VALUE 'M'.
                    88 IMPORTER       VALUE 'I'.
               10  SUPPLIER-NAME     PIC X(15) VALUE SPACES. *> 104-118
               10  SUPPLIER-PERF     PIC 9(03) VALUE ZERO.   *> 119-121
               10  SUPPLIER-RATING   PIC X(01) VALUE SPACES. *> 122-122
                    88 HIGHEST-QUALITY VALUE '3'.
                    88 AVERAGE-QUALITY VALUE '2'.
                    88 LOWEST-QUALITY  VALUE '1'.
               10  SUPPLIER-STATUS   PIC X(01) VALUE SPACES. *> 123-123
                    88 GOVT-COMM       VALUE '1'.
                    88 GOVT-ONLY       VALUE '2'.
                    88 COMMERCIAL-ONLY VALUE '3'.
               10  SUPPLIER-ACT-DATE PIC 9(08) VALUE ZERO.   *> 123-130
           05 SUPP-ADDRESS OCCURS 3 TIMES INDEXED BY ADDR-IDX. *> 131-
               10 ADDRESS-TYPE      PIC X(01) VALUE SPACES. *> 131-131
                  88 ORDER-ADDRESS            VALUE '1'.
                  88 SCHED-ADDRESS            VALUE '2'.
                  88 REMIT-ADDRESS            VALUE '3'.
               10 ADDRESS-1         PIC X(15) VALUE SPACES. *> 132-146
               10 ADDRESS-2         PIC X(15) VALUE SPACES. *> 147-161
               10 ADDRESS-3         PIC X(15) VALUE SPACES. *> 162-176
               10 CITY              PIC X(15) VALUE SPACES. *> 177-192
               10 ADDR-STATE        PIC X(02) VALUE SPACES. *> 193-194
               10 ZIP-CODE          PIC 9(10) VALUE ZERO.   *>
           05 PURCHASE-ORDER OCCURS 3 TIMES INDEXED BY PO-IDX.
               10  PO-NUMBER         PIC X(06) VALUE SPACES.
               10  BUYER-CODE        PIC X(03) VALUE SPACES.
               10  QUANTITY          PIC S9(7) VALUE ZERO.
               10  UNIT-PRICE        PIC S9(7)V99 VALUE ZERO.
               10  ORDER-DATE        PIC 9(08) VALUE ZERO.
               10  DELIVERY-DATE     PIC 9(08) VALUE ZERO.
