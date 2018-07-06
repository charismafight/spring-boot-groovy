package com.lee.demo

@Grab("spring-boot-starter-actuator")
@Grab("thymeleaf-spring5")

@Controller
@RequestMapping("/")
class ContactController {

    @Autowired
    ContactRepository contactRepository

    @RequestMapping(method = RequestMethod.GET)
    String home(Map<String, Object> model) {
        List<Contact> list = contactRepository.findAll()
        model.putAll([list: list])
        return "../templates/home"
    }

    @RequestMapping(method = RequestMethod.POST)
    String submit(Contact contact) {
        contactRepository.save(contact)
        return "redirect:/"
    }
}
