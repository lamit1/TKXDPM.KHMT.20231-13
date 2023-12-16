# TKXDPM.VN.20231-13
Template for managing Capstone's project in the Software Design and Construction course in the 2023.1 semester.

## Table of contents

- [TKXDPM.VN.20231-01](#tkxdpmvn20231-01)
  - [Table of contents](#table-of-contents)
  - [Quick start](#quick-start)
  - [What's included](#whats-included)
  - [Report Content](#report-content)
  - [Pull request template](#pull-request-template)
  - [QA](#qa)
  - [Creators](#creators)

## Quick start

Before using this Github repository, everyone needs to register their group information using the table below:

| Name              | Role        |
| :-------------    | :---------- |
| Nông Hoàng Lâm    | Team Leader |
| Nguyễn Văn Lợi    | Member      |
| Nguyễn Ngọc Linh  | Member      |
| Lang Thành Long   | Member      |

## What's included

The recommended structure is as follows:

- `AIMS`: folder containing the team's AIMS base code
- `assets`: folder containing images that you want to include in the report file
- `README.md`: weekly report file, individuals are required to update their tasks and how their do it into this file
- `Template.md`: template for the weekly report
- `pull_request_template.md`: pull request's description template

## Report Content

The recommended report structure will have a format as follows:

<details>
  <summary>W13: 25/11/2023~03/12/2023 </summary>
<br>
<details>
<summary>Nông Hoàng Lâm</summary>
<br>

- Assigned tasks:
  - Add comment about coupling to subsystem folder 

- Implementation details:
  - Pull Request(s): [https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/1](https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/1)
  - Specific implementation details:
    - Xem xét các phương thức của từng lớp trong folder AIMS/ subsytem
    - Thêm phần comment vào tại các nơi diễn ra coupling.

</details>

<details>
<summary>Vũ Văn Lợi</summary>
<br>

- Assigned tasks:
  - Add comment about coupling to views and controller folder 

- Implementation details:
  - Pull Request(s): [https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/3](https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/3)
  - Specific implementation details:
    - Xem xét các phương thức của từng lớp trong folder AIMS/ controller và AIMS/ views
    - Thêm phần comment vào tại các nơi diễn ra coupling.

</details>

<details>
<summary>Nguyễn Ngọc Linh</summary>
<br>

- Assigned tasks:
  - Add comment about coupling to utils folder 

- Implementation details:
  - Pull Request(s): [https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/4](https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/4)
  - Specific implementation details:
    - Xem xét các phương thức của từng lớp trong folder AIMS/ utils
    - Thêm phần comment vào tại các nơi diễn ra coupling.

</details>



</details>

---

<details>
  <summary>W14: 03/12/2023~10/12/2023 </summary>
<br>
<details>
<summary>Nông Hoàng Lâm</summary>
<br>

- Assigned tasks:
  - Cohesion Comment on subsystem and entity folder

- Implementation details:
  - Pull Request(s): [https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/5]](https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/5)
  - Specific implementation details:
    - Add comment cohesion in folder entity and subsytem

</details>

<details>
<summary>Nguyễn Ngọc Linh</summary>
<br>

- Assigned tasks:
  - Cohesion Comment on controller and ultil folder

- Implementation details:
  - Pull Request(s): [https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/6]](https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/6)
  - Specific implementation details:
    - Add comment cohesion in folder controller and ultil

</details>


<details>
<summary>VŨ VĂN LỢI</summary>
<br>

- Assigned tasks:
  - Cohesion Comment on screen folder

- Implementation details:
  - Pull Request(s): [https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/7]](https://github.com/lamit1/TKXDPM.KHMT.20231-13/pull/6)
  - Specific implementation details:
    - Add comment cohesion in folder screen

</details>
<summary>Team Member 1</summary>
<br>

- Assigned tasks:
  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

<details>
<summary>Team Member 2</summary>
<br>

- Assigned tasks:
  - Task 1
  - Task 2
  - ...

- Implementation details:
  - Pull Request(s): [Attach links to your pull requests here. You can attach multiple pull requests]()
  - Specific implementation details:
    - Describe specific in detail what you did last week
    - You can attach images if you want

</details>

</details>

---

## Pull request template

- You are required to create a pull request according to these steps:
  - Use the `pull_request_template.md` file when writing the description section in the pull request
  - The `title` of the pull request should follow the format below:
    - `Feature/Topic/Hotfix/Fix: Task Name`. Example: `Feature: Build View Controller`
    - Explain:
      - `Feature`: When the branch has the task of changing the main code of the project
      - `Topic`: When the branch only has the task of research, without directly changing the main code of the project
      - `Hotfix`: When you discover code on the production environment
      - `Fix`: When you discover a bug in a branch that has not been merged into the production environment
  - After creating the pull request, decide who will merge the code within your team.
  - You don't need to follow the Wxx format as I mentioned before
  - Each person will have multiple pull requests
  - Whoever makes the pull request, attach that pull request to the report you attached above. Section `pull request(s)`
