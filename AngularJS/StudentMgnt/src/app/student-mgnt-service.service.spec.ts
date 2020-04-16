import { TestBed } from '@angular/core/testing';

import { StudentMgntServiceService } from './student-mgnt-service.service';

describe('StudentMgntServiceService', () => {
  let service: StudentMgntServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentMgntServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
