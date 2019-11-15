import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { NzMessageService, NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.scss']
})
export class CourseListComponent implements OnInit {

  // Init form data
  validateForm: FormGroup;

  // Dropdown list for skill list : Front/Back/Music
  skillTypeList: any;

  // Page Info
  pageSize: number;
  pageIndex: number;
  total: number;

  // Datagrid
  dataSet = [];
  loading = true;

  // Query Parameters
  skillType: string = '';
  mentorName: string = '';


  constructor(private router: Router,
    private http: HttpClient,
    private datePipe: DatePipe,
    private msg: NzMessageService,
    private modalService: NzModalService,
    private activatedRoute: ActivatedRoute,
    private nzMessageService: NzMessageService) { }

  // Data initaion
  ngOnInit() {
    this.pageSize = 8;
    this.pageIndex = 1;
    this.getSkillTypeList();
    this.refreshPage();
  }


  // Data Init
  refreshPage() {
    this.getQueryList().subscribe(res => {
      console.log(res);
      this.dataSet = res.rows;
      this.total = res.total;
      this.loading = false;
    })
  }


  // Query Functin
  getQueryList() {
    this.loading = true;

    let json = {
      skillType: this.skillType == null ? "" : this.skillType,
      page: this.pageIndex == null ? 1 : this.pageIndex,
      pageSize: this.pageSize == null ? 8 : this.pageSize
    }

    return this.http.post('course/list', json);
  }


  // Init dropdown list
  getSkillTypeList(): any {
    this.http.get('course/skillTypeList/').subscribe(res => {
      this.skillTypeList = [];
      this.skillTypeList.push({ key: '', value: 'ALL' });
      res.forEach(element => {
        this.skillTypeList.push({ key: element.skillId, value: element.skillName });
      });
    });
  }

  // Disable class
  disableCourse(id) {
    this.http.delete('course/disable/' + id).subscribe(res => {
      if (res.data == true) {
        this.nzMessageService.info('This course have already been disabled');
      }
    });
  }

  submitForm(obj) {
    this.skillType = obj.skillType
    this.mentorName = obj.mentorName;
    this.pageIndex = 1;
    this.refreshPage();
  }

  clearAll() {
    let obj = this.validateForm.controls;
    for (var key in obj) {
      obj[key].setValue(null);
    }
  }
}
