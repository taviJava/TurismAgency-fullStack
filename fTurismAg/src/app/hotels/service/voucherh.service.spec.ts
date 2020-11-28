import { TestBed } from '@angular/core/testing';

import { VoucherhService } from './voucherh.service';

describe('VoucherhService', () => {
  let service: VoucherhService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VoucherhService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
